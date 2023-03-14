DESCRIPTION
-----------

##### Goal
The goal of this project is to present how to use Git pre-commit tool with simple "Hello World" Java Spring Boot application.

##### Details
* Git pre-commit tool checks code according to specific rules on demand or before every commit to Git repository
* More details about Git pre-commit tool you can find here: `https://docs.google.com/document/d/1Ff8DZYWNI4MfoHINrtEb5q2-0iVckp0LoVPeljMev_U/edit?usp=sharing`
* This example application displays text: "Hello World".


PRECONDITIONS
-------------

##### Preconditions - Tools
* Installed Java
* Installed Maven
* Installed Git
* Installed Git pre-commit

##### Preconditions - Actions
* Download Source Code with `git clone https://github.com/wisniewskikr/java-springboot.git`


USAGE
-----

Usage steps:
1. Install pre-commit in specific local reporisoty with `pre-commit install`
2. Update source code for instance by adding whitespace in **README.md** file after text **DESCRIPTION**
3. Add files to repository

    * Add files to repository with `git add .`
    * Check repository status with `git status`
4. Run pre-commit (optional). Expected result: **First** pre-commit failed and fixed. **Second** pre-commit passed.

    * Run pre-commit with `pre-commit run`
    * Add files to repository with `git add .`
    * Check repository status with `git status`
    * Run again pre-commit with `pre-commit run` 
5. Commit changes. Expected result: **First** pre-commit failed and fixed. **Second** pre-commit passed.

    * Create commit with `git commit -m "Init tmp project"`
    * Add files to repository with `git add .`
    * Check repository status with `git status`
    * Create commit again with `git commit -m "Init tmp project"`
	
6. Clean up environment

    * Remove last commit with `git reset --hard HEAD~1`
    * Uninstall pre-commit tool with `pre-commit install`