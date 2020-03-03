# Changelog

All notable changes to the PIPE42 project will be documented in this file.

The latest stable production branch will always be [MASTER] once we are out of alpha.

### [Unreleased]

- Full search, delete and edit capability for a Project

### [0.2.0-alpha] - 2020-03-03

#### Added

- Projects can now be edited and deleted
- Added Logback with SLF4J for logging
- Added various unit tests

#### Changed

- Complete rewrite of the database design patterns. Now uses an Abstract Factory design for the code to be independent of underlying database.
- Decided to drop MongoDB in favor of SQLlite for a number of reasons but mainly portability and the
fact that the data is now so structured that a relational solution makes tons of sense.
- Refactored quite a chunk of code to make methods and classes cleaner.

### [0.1.0-alpha] - 2020-02-25

#### Added

- Wrapper classes and logic for the comboboxes in the "Project/New Project" menu UI
- Added this file and started with proper versioning

#### Changed

- Made some changes to the README.md file
- General housekeeping versus Github

[MASTER]: https://github.com/mydogspies/pipe42
[unreleased]: https://github.com/mydogspies/pipe42/tree/develop
[0.1.0-alpha]: https://github.com/mydogspies/pipe42/tree/v0.1.0-alpha
[0.2.0-alpha]: https://github.com/mydogspies/pipe42/tree/v0.2.0-alpha
