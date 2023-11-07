# Startdocument Athletics Club

Start Document of **Tung Do Xuan**, Student number **4679687**.

## Problem Description

An athletic club application that allow the following: 

- Athlete can be created with name.
- Athlete can run on two different track of Grass (300m) or Gravel(400m) and have their lap time recorded in seconds. 
- The lap time of Grass track is reduced by 5 seconds. 
- The club can get the fastest athlete by the Athlete's object name and lap time.
- The club can get the fastest athlete by track type.
- The club can show each athlete's total distance, average lap time, max speed, total time athlete has run.

## Input and Output

In this section the in- and output of the application will be described.

### **Input**

#### Athlete

| Case |   Type    |      Conditions      |
|:----:| :-------: |:--------------------:|
| name | `String`  | not null & not empty |

#### Lap

|  Case   |   Type    | Conditions  |
|:-------:|:---------:|:-----------:|
| athlete | `Athlete` |      -      |
|  track  |  `Track`  |      -      |
|  time   | `double`  | number >= 0 |

#### Track

|   Case   |    Type     |              Conditions              |
|:--------:|:-----------:|:------------------------------------:|
|   type   | `TrackType` | TrackType.GRASS or TrackType.GRAVEL  |

#### Club

| Case | Type | Conditions |
|:----:|:----:|:----------:|
|  -   | `-`  |     -      |

### **Output**

|                              Case                               |   Type    |
|:---------------------------------------------------------------:|:---------:|
|                      `addLapTime(Lap lap)`                      |  `void`   |
|            `getTotalLapsByAthlete(Athlete athlete)`             |   `int`   |
|          `getTotalDistanceByAthlete(Athlete athlete)`           | `double`  |
|           `getAverageTimeByAthlete(Athlete athlete)`            | `double`  |
|            `getTotalTimeByAthlete(Athlete athlete)`             | `double`  |
|             `getMaxSpeedByAthlete(Athlete athlete)`             | `double`  |
|                 `getFastestAthleteAndLapTime()`                 | `String`  |
|   `getFastestAthleteOnCertainTrackType(TrackType trackType)`    | `Athlete` |

## UML diagram

![](https://i.imgur.com/WM3nXjP.png)

## Test Data

In this section test data, and the test cases will be provided.

### Club

### Athlete

|  Object   |  name   |
|:---------:|:-------:|
|  athlete  |  "Tom"  |
| athlete1  | "Jerry" |

### Track

|   Object   |          type          |
|:----------:| :--------------------: |
|   grass    | TrackType.GRASS_TRACK  |
|   gravel   | TrackType.GRAVEL_TRACK |

### Lap

| Object | Athlete  | Track  | duration |
|:------:|:--------:|:------:|:--------:|
|  lap   | athlete  | grass  |   100    |
|  lap1  | athlete  | gravel |   200    |
|  lap2  | athlete1 | grass  |   300    |
|  lap3  | athlete1 | gravel |   400    |

## Test case

### Athlete/testThrowExceptionWithInvalidName

|  #   |           Action           |        Expected output         |
| :--: |:--------------------------:|:------------------------------:|
|  1   |     `new Athlete("")`      |    IllegalArgumentException    |

### Lap/testThrowExceptionWithInvalidTime

|  #   |           Action            |      Expected output       |
| :--: |:---------------------------:|:--------------------------:|
|  1   |`new Lap(athlete, grass, -1)`|  IllegalArgumentException  |

### Lap/getSpeed

|  #   |      Action      |                   Expected output                   |
| :--: |:----------------:|:---------------------------------------------------:|
|  1   | `lap.getSpeed()` |lap.getTrack().getType().getDistance()/lap.getTime() |

### Lap/getTime

|  #   |         Action         | Expected output |
| :--: | :---------------------:|:---------------:|
|  1   |     `lap.getTime()`    |       95        |


### Lap/setTime

|  #   |       Action       | Expected output |
| :--: |:------------------:|:---------------:|
|  1   | `lap.setTime(100)` |       100       |

### Club/addLapTime

| #  |         Action          | Expected output |
|:--:|:-----------------------:|:---------------:|
| 1  | `club.addLapTime(lap)`  |        -        |
| 2  | `club.addLapTime(lap1)` |        -        |
| 3  | `club.addLapTime(lap2)` |        -        |
| 4  | `club.addLapTime(lap3)` |        -        |
| 5  | `club.getLaps().size()` |        4        |

### Club/getTotalLapsByAthlete

|  #   |                Action                 | Expected output |
| :--: |:-------------------------------------:|:---------------:|
|  1   | `club.getTotalLapsByAthlete(athlete)` |        2        |

### Club/getTotalDistanceByAthlete

|  #   |                  Action                   |            Expected output            |
| :--: |:-----------------------------------------:|:-------------------------------------:|
|  1   | `club.getAverageTimeByAthlete(athlete)` | (lap.getTime() + lap1.getTime()) / 2  |

### Club/getAverageTimeByAthlete

|  #   |           Action           |                       Expected output                        |
| :--: | :------------------------: | :----------------------------------------------------------: |
|  1   | `club.getFastestAthlete()` | The fastest athlete is id=0, athleteName='John', totalTime=120, totalDistance=600 with PR of: 55 seconds |

### Club/getTotalTimeByAthlete

|  #   |                Action                 |        Expected output         |
| :--: |:-------------------------------------:|:------------------------------:|
|  1   | `club.getTotalTimeByAthlete(athlete)` | lap.getTime() + lap1.getTime() |

### Club/getMaxSpeedByAthlete
|  #   |                Action                 | Expected output |
| :--: |:-------------------------------------:|:---------------:|
|  1   | `club.getMaxSpeedByAthlete(athlete)` | lap.getSpeed()  |

### Club/getFastestAthleteAndLapTime

|  #   |                Action                 | Expected output |
| :--: |:-------------------------------------:|:---------------:|
|  1   | `club.getFastestAthleteAndLapTime()` |    Tom 95.0     |

### Club/getFastestAthleteOnCertainTrackType

|  #   |                            Action                            | Expected output |
| :--: |:------------------------------------------------------------:|:---------------:|
|  1   | `club.getFastestAthleteOnCertainTrackType(TrackType.GRAVEL)` |    athlete     |

### Club/removeLap

| # |        Action         | Expected output |
|:-:|:---------------------:|:---------------:|
| 1 | `club.removeLap(lap)` |        -        |
| 2 | `club.getLaps.size()` |        3        |

