# Changelog

Notable changes to the source code for this project will be recorded here. 

## Version - 2019/02/12v1

### Added
* Main class - creates all objects needed to start the program
### Changed
* AppController - runController method - now has ability to logout, add/remove login details from AuthServer.
* LoginRecord - now has methods to get the username, date or both of record
### Fixed
* AppController - login method - now takes parameters
### Removed
AppController - main method - moved from the AppController to Main class



## Version - 2019/02/08

### Changed
* runController method - on logout, page is redirected to login.



## Version - 2019/02/05

### Added
* LoginRecord class
* login method to AppController
* logout method to AppController
* AuthServer class