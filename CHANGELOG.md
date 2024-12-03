# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Calendar Versioning](https://calver.org/) of
the following form: YYYY.0M.0D.

## [Assignment 5] 2024.12.03

### Added

- Designed kernel implementation for ShotTracker component

### Updated

- Included all kernel methods from ShotTrackerKernel interface
- Included all standard methods including transferFrom, clear, newInstance
- Created an iterator for the ShotTracker component

## [Assignment 4] 2024.11.12

### Added

- Designed abstract class for ShotTracker component

### Updated

- Added a ToString implementation and equals implementation

## [Assignment 3] - 2024.10.17

### Added

 - Designed interfaces for ShotTracker, ShotTrackerKernel, and ShotTracker.Shot

### Updated

 - Removed the getDistance and getClubType methods from the ShotTrackerKernel, instead replacing them with getShot
 - Added an internal class Shot that models each individual shot and contains 3 methods, getDistance, getShotType, and getClubType

## [Assignment 2] - 2024.10.03

### Added

- Designed a proof of concept for shotTracker component

### Updated

- Changed design to include two more kernel methods getDistance and getClubType
- Updated variables clubType and shotType to be integers instead of Strings

## [Assignment 1] - 2024.09.16

### Added

- Designed a ClimbingHelper component
- Designed an Inventory component
- Designed a ShotTracker component