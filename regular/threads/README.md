THREADS
=======


DESCRIPTION
-----------

Goal of this project is to show how to work with threads in Java. Most important thing: 
to start new thread you have to use method **start()**, not method run(). 
Method run() won't run new thread.

Example: we have count() methods which counts from 1 to 100 and displays it on Console. 
And we run this method in many threads.

You can work with threads in following ways:
* **anonymous method**: create new Thread with anonymous method;
* **custom thread class**: create custom Thread which extends class Thread;
* **custom runnable interface**: create class with implements interface Runnable. This class should be place in Thread;
* **executor service**: use ExecutorService class to create pool of Threads.


USAGE
-----

Please open class **Main** and run method **main()**.