JSON GSON
=========


DESCRIPTION
-----------

Goal of this project is to show how to work with Json in Java project using Gson library. 
Solution is presented on sophisticated object Item (with objects, primitives, lists, sets and maps inside). Following actions are done on this object:
* converting object Item to Json as String;
* converting Json as String to object Item.

Gson library by default works very good. There is only problem when we use **Map<Object, Object>** inside object. But to resolve this problem we have to just init Gson by:

* Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();

instead of:

* Gson gson = new Gson();

**Sumary**
In my opinion developer should use this library to work with Json in Java. This library is a little better then Jackson library.


USAGE
-----

Please open class **Main** and run method **main()**.