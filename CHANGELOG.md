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