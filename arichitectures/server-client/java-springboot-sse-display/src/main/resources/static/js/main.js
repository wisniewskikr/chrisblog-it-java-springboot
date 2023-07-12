'use strict';

var usernamePage = document.querySelector('#username-page');
var chatPage = document.querySelector('#chat-page');
var messageInput = document.querySelector('#message');
var messageArea = document.querySelector('#messageArea');
var connectingElement = document.querySelector('.connecting');
var chatName = document.querySelector('#chat-name');
var chatButton = document.querySelector('#chat-button');
var username;
var index = 0;

var colors = [
    '#2196F3', '#32c787', '#00BCD4', '#ff5652',
    '#ffc107', '#ff85af', '#FF9800', '#39bbb0'
];

function logIn() {
    username = document.querySelector('#name').value.trim();

    if(username) {
        chatName.textContent = username;
        usernamePage.classList.add('hidden');
        chatPage.classList.remove('hidden');
        connectingElement.classList.add('hidden');

        readInit();
    }

}

function sendChat() {
    var messageContent = messageInput.value.trim();

    if(!messageContent) {
      return;
    }

    var chatMessage = {
        index: index,
        sender: username,
        content: messageInput.value
    };        

    send(chatMessage);         
    
}

function send(chatMessage) {

    const url = 'http://localhost:8080/send';

    const options = {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(chatMessage),
    };

    fetch(url, options)
      .then((response) => response.json())
      .then((data) => {
        index = data.id;
        displayMessage(JSON.stringify(chatMessage));
        messageInput.value = "";
      }).catch((error) => {
        console.log(error);
      });

}

function readInit() {

  var intervalId = window.setInterval(function(){
    readChat();
  }, 3000);  

}

function readChat() {

  var readRequest = {
      id: index
  };        

  read(readRequest);         
  
}

function read(readRequest) {

  const url = 'http://localhost:8080/read';

  const options = {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(readRequest),
  };

  fetch(url, options)
    .then((response) => response.json())
    .then((data) => {

      if (data.id == 0) {
        return;
      }
      index = data.id;
      displayMessage(JSON.stringify(data));

    }).catch((error) => {
      console.log(error);
    });

}

function displayMessage(messageString) {

    var message = JSON.parse(messageString);

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