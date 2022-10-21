SORTING SET OF OBJECTS
=======================


DESCRIPTION
-----------

Goal of this project is to show how to sort set of objects in Java. 

Sorting depends on Set types:
* **HashSet**: sorting is not possible;
* **LinkedHashSet**: order in Set depends on order in adding. Sorting: 
     * manual; 
     * stream; 
     * convert to list and then all possibilities of list.
* **TreeSet**: order in Set depends on build in Comparator. Sorting is done automatically. 


THEORY
------

You should use Set if you want to be sure that elements in this Collection are unique.

Types:
* **HashSet**: use it if you don’t want to maintain any order of elements. It has the fastest performance;
* **LinkedHashSet**: use it if you want to maintain insertion order of elements. It is slower then HashSet but faster then TreeSet;
* **TreeSet**: user it if you want to sort the elements according to some Comparator. It has the slower performance because it has to do sorting every time.


USAGE
-----

Please open class **Main** and run method **main()**.