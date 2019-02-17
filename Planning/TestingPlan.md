# Testing and Issue Control Plan
## Testing

Tests will be done before each push to the main server repository, and must follow some pass rules before pushing:
* Any tests that pass when the branch was made **MUST NOT** fail when the branch is merged into the master branch.
* Any bugs that stop previously passed tests from passing **MUST** be fixed before merging. 
* Tests **MUST** pass on another team member's machine before merging with the master branch. 
* After merging, the master branch **MUST** pass all previously passed tests or the merge will be reverted and fixed.
* Tests are to be implemented as JUnit tests, aiming for a high level of code and branch coverage. 
* Any functionality that is found not to be tested should have a test written for it and added here; with a note of when it was added. This note should be included in the amendments section at the end of the document to track changes.
### Planned Tests
* **Log In**
    * Attempt to log in with incorrect details. 
        * Passes if login fails and attempt is stored in system. 
    * Attempt to log in as standard employee with valid details. 
        * Passes if login successful, attempt is stored in system, system is logged in as correct user.
    * Attempt to log in as HR Employee with valid details. 
        * Passes if they're now logged in as the correct user.
    * Attempt to log in as HR Employee/Director with valid details, but lower privileges.
        * Passes if logged in as correct user and fails to create new "Personal Details Document"       


* **Log Out**
    * Log out from all user types (Director, HR Employee, Employee) in turn.
        * Passes if user no longer has access rights and system recorded logged out user.


* **Read Personal Details** 
    * Attempt to view associated personal details for logged in employee (Non-HR).
        * Passes if correct document is delivered to the user.
    * Attempt to view personal details for a different employee to logged in user (Non-HR). 
        * Passes if authorization fails and no documents are delivered.
    * Attempt to view personal details for another employee as HR employee.
        * Passes if document is successfully delivered to user.
    * Attempt to read document for employee that does not exist.
        * Passes if no documents are supplied. 


* **Create Personal Details**
    * Create document for new staff member as HR employee and fill in.
        * Passes if new document can be read from the database (readPersonalDetails).
    * Create document as non-HR employee. 
        * Passes if authorisation check fails.
    * Create document as HR employee for a staff member that already exists.
        * Passes if no documents are created. 


* **Amend Personal Details**
    * Amend document request as HR employee, fill in new details.
        * Passes if new details are saved to database.
    * Amend request for document that does not exist as HR employee.
        * Passes if no documents are changed. 

* **Create new Review Record**
    * Create document as HR employee.
        * Passes if form is saved successfully to database. 
            
        
* **Read Review Record**
    * Read document pertaining to logged in employee.
        * Passes if document is successfully delivered.
    * Read document pertaining to employee managed by logged in employee.
        * Passes if document is delivered successfully. 
    * Read document pertaining to employee being reviewed by logged in employee.
        * Passes if document is delivered successfully. 
    * Read document that pertains to a non-managed employee as manager.
        * Passes if authorisation fails and document is not delivered. 
    
    
* **Amend Review Record**
    * Amend document that is not completed as reviewer.
        * Passes if edited document is saved to the database. 
    * Amend incomplete document as reviewed employee.
        * Passes if edited document is saved to database.


* **Read Past Completed Review Records**
    * Read documents as employee.
        * Passes if employee is presented with all previous review documents that pertain to them.
    * Read documents as reviewer of employee documents pertain to.
        * Passes if documents are delivered successfully.


* **Perform Review**
    * Attempt review outside of review period (2 weeks from anniversary of employment).
        * Passes if request is rejected and nothing is changed. 
    * Perform review within review period, review is signed off.
        * Passes if participants are presented with past review documents (if they exist), review record has been amended, and HR has been informed.
    * Perform review within review period, no conclusion. 
        * Passes if no changes are made to the document and a new meeting is scheduled. 


* **Allocate Reviewer**
    * HR employee allocates reviewers to an employee review. 
        * Passes if the direct manager of the employee is a reviewer and another higher level employee or director is a reviewer, and both have been informed of the date. 
    * HR employee attempts to allocate reviewers to a review, but no 2<sup>nd</sup> reviewer was selected.
        * Passes if no reviewers were allocated. 


## Bug Reporting
Bug reports are to be handled using the 'Issue' system on GitLab. 

The person who is making the report should assign it to the person responsible for that part of the program. 
This information can be found by referring to the latest meeting documents, which will contain the person who is assigned to that part of the project. 

## Amendments
* 2019-02-11:  Document amended to include the type of tests being used (JUnit) and mentions the amendments section. 