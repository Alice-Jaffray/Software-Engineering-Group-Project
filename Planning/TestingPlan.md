# Testing Plan

Refer to the brief and cover all of the points mentioned, using the notes made in the [meeting document](../Meeting Notes/Stage 2/2019-01-29-Meeting1.md).

## Testing

Tests will be done before each push to the main server repository, and must follow some pass rules before pushing:
* Any tests that pass when the branch was made **MUST NOT** fail when the branch is merged into the master branch.
* Any bugs that stop previously passed tests from passing **MUST** be fixed before merging. 
* Tests **MUST** pass on another team member's machine before merging with the master branch. 
### Planned Tests
* Log In
    * Attempt to log in with incorrect details. 
        * Passes if login fails and attempt is stored in system. 
    * Attempt to log in as standard employee with valid details. 
        * Passes if login successful, attempt is stored in system, system is logged in as correct user.
    * Attempt to login as HR Employee with valid details. 
        * Passes if the now logged in user passes an authorisation check to create a personal details document.  
    

## Bug Reporting
Bug reports are to be handled using the 'Issue' system on GitLab. 

The person who is making the report should assign it to the person responsible for that part of the program. 
This information can be found by referring to the latest meeting documents, which will contain the person who is assigned to that part of the project. 