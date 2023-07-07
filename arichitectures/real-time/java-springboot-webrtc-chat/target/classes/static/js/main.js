'use strict';

var usernamePage = document.querySelector('#username-page');
var chatPage = document.querySelector('#chat-page');
var usernameForm = document.querySelector('#usernameForm');
var messageInput = document.querySelector('#message');
var messageArea = document.querySelector('#messageArea');
var connectingElement = document.querySelector('.connecting');
var chatName = document.querySelector('#chat-name');
var username = null;

var colors = [
    '#2196F3', '#32c787', '#00BCD4', '#ff5652',
    '#ffc107', '#ff85af', '#FF9800', '#39bbb0'
];

function connect(event) {
    username = document.querySelector('#name').value.trim();

    if(username) {
        chatName.textContent = username;
        usernamePage.classList.add('hidden');
        chatPage.classList.remove('hidden');
        connectingElement.classList.add('hidden');
    }
    event.preventDefault();
}

function sendChat() {
    var messageContent = messageInput.value.trim();

    if(messageContent) {
        var chatMessage = {
            sender: username,
            content: messageInput.value,
            type: 'CHAT'
        };        

        dataChannel.send(JSON.stringify(chatMessage));
        onMessageReceived(JSON.stringify(chatMessage));
    }
}

function onMessageReceived(payload) {

    var message = JSON.parse(payload);

    var messageElement = document.createElement('li');

    messageElement.classList.add('chat-message');

    var avatarElement = document.createElement('i');
    var avatarText = document.createTextNode(message.sender[0]);
    avatarElement.appendChild(avatarText);
    avatarElement.style['background-color'] = getAvatarColor(message.sender);

    messageElement.appendChild(avatarElement);

    var usernameElement = document.createElement('span');
    var usernameText = document.createTextNode(message.sender);
    usernameElement.appendChild(usernameText);
    messageElement.appendChild(usernameElement);

    var textElement = document.createElement('p');
    var messageText = document.createTextNode(message.content);
    textElement.appendChild(messageText);

    messageElement.appendChild(textElement);

    messageArea.appendChild(messageElement);
    messageArea.scrollTop = messageArea.scrollHeight;

}


function getAvatarColor(messageSender) {
    var hash = 0;
    for (var i = 0; i < messageSender.length; i++) {
        hash = 31 * hash + messageSender.charCodeAt(i);
    }

    var index = Math.abs(hash % colors.length);
    return colors[index];
}

// ***** start webrtc

//connecting to our signaling server 
var conn = new WebSocket('ws://localhost:8080/socket');

conn.onopen = function() {
    console.log("Connected to the signaling server");
    initialize();    
};

conn.onmessage = function(msg) {
    console.log("Got message", msg.data);
    var content = JSON.parse(msg.data);
    var data = content.data;
    switch (content.event) {
    // when somebody wants to call us
    case "offer":
        handleOffer(data);
        break;
    case "answer":
        handleAnswer(data);
        break;
    // when a remote peer sends an ice candidate to us
    case "candidate":
        handleCandidate(data);
        break;
    default:
        break;
    }
};

function send(message) {
    conn.send(JSON.stringify(message));
}

var peerConnection;
var dataChannel;

function initialize() {
    var configuration = null;

    peerConnection = new RTCPeerConnection(configuration);

    // Setup ice handling
    peerConnection.onicecandidate = function(event) {
        if (event.candidate) {
            send({
                event : "candidate",
                data : event.candidate
            });
        }
    };

    // creating data channel
    dataChannel = peerConnection.createDataChannel("dataChannel", {
        reliable : true
    });

    dataChannel.onerror = function(error) {
        console.log("Error occured on datachannel:", error);
    };

    // when we receive a message from the other peer, printing it on the console
    dataChannel.onmessage = function(event) {
        console.log("message:", event.data);
        onMessageReceived(event.data);
    };

    dataChannel.onclose = function() {
        console.log("data channel is closed");
    };
  
  	peerConnection.ondatachannel = function (event) {
        dataChannel = event.channel;
  	};
    
}

function createOffer() {
    peerConnection.createOffer(function(offer) {
        send({
            event : "offer",
            data : offer
        });
        peerConnection.setLocalDescription(offer);
    }, function(error) {
        alert("Error creating an offer");
    });
}

function handleOffer(offer) {
    peerConnection.setRemoteDescription(new RTCSessionDescription(offer));

    // create and send an answer to an offer
    peerConnection.createAnswer(function(answer) {
        peerConnection.setLocalDescription(answer);
        send({
            event : "answer",
            data : answer
        });
    }, function(error) {
        alert("Error creating an answer");
    });

};

function handleCandidate(candidate) {
    peerConnection.addIceCandidate(new RTCIceCandidate(candidate));
};

function handleAnswer(answer) {
    peerConnection.setRemoteDescription(new RTCSessionDescription(answer));
    console.log("connection established successfully!!");
};

// function sendMessage(message) {
//     dataChannel.send(message);
// }

// ***** stop webrtc

usernameForm.addEventListener('submit', connect, true)
