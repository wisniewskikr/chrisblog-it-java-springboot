ARRAY EQUILIBRIUM INDEX
=======================


DESCRIPTION
-----------

Goal of this project is to show how to find equilibrium index in array.
Equilibrium index means such point in array that sum of all elements from left side equals sum af all elements from right side.

Equilibrium index can be resolved in 3 ways:
- **Incremental**: we added all elements in one loop. In second loop we add new element to 0 (left side) and remove element from sum (right side);
- **Iterative**: we create one temporary array where every index contain sum of elements to this index;
- **Brute Force**: three loops - one common and two counts left and right side.


USAGE
-----

Please open class **Main** and run method **main()**.