JSON JACKSON
============


DESCRIPTION
-----------

Goal of this project is to show how to work with Json in Java project using Jackson library. 
Solution is presented on sophisticated object Item (with objects, primitives, lists, sets and maps inside). Following actions are done on this object:
* converting object Item to Json as String;
* converting Json as String to object Item.

There is few problems with Jackson library:
* it requires constructor without arguments;
* exception JsonProcessingException has to be handled here;
* when object contains Map<Object, Object> then developer has to create his own KeyDeserializer. 
And this KeyDeserializer should be injected by annotation: @JsonDeserialize(keyUsing = AgeDeserializer.class)

**Summary**
In my opinion Gson library is a little better then Jackson library.


USAGE
-----

Please open class **Main** and run method **main()**.