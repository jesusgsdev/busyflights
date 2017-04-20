[![Build Status](https://travis-ci.org/jesusgsdev/busyflights.svg?branch=master)](https://travis-ci.org/jesusgsdev/busyflights)
# BusyFlights
### Problem to be solved
#### Background:
BusyFlights is a flights search solution which aggregates flight results from 2 different suppliers
(CrazyAir and ToughJet).

### What is required:
1. The service (search solution) needs to be a springboot application.
2. The service should produce an aggregated result from both CrazyAir and ToughJet.
3. The service should produce a JSON response which contains a list of flights ordered by fare
which has the following attributes:

|Name|Description|
|---|---|
|airline |Name of Airline|
|supplier |Eg: CrazyAir or ToughJet|
|fare |Total price rounded to 2 decimals|
|departureAirportCode| 3 letter IATA code(eg. LHR, AMS)|
|destinationAirportCode| 3 letter IATA code(eg. LHR, AMS)|
|departureDate| Date Time in ISO8601|
|arrivalDate| Date Time in ISO8601|

The service should expose the following search attributes:

|Name|Description|
|---|---|
|origin| 3 letter IATA code(eg. LHR, AMS)
|destination| 3 letter IATA code(eg. LHR, AMS)
|departureDate| Date in ISO8601
|returnDate| Date in ISO8601
|numberOfPassengers| Maximum 4 passengers

- The service should log the request and response from each of the suppliers for debugging
purposes. This should preferably be done using AspectJ.
- The service should connect to the both the suppliers using HTTP.

#### CrazyAir API
##### Request
The request expected:

|Name|Description|
|---|---|
|origin| 3 letter IATA code(eg. LHR, AMS)
|destination| 3 letter IATA code(eg. LHR, AMS)
|departureDate| mm-dd-yyyy
|returnDate| mm-dd-yyyy
|numberOfPassengers| Number of passengers

##### Response
The response provided by CrazyAir contains a list of flights with the following attributes:

|Name|Description|
|---|---|
|airline| Name of the airline
|price| Total price
|cabinclass| E for Economy and B for Business
|departureAirportCode| Eg: LHR
|destinationAirportCode| Eg: LHR
|departureDate| mm-dd-yyyy HH:MM:ss
|arrivalDate| mm-dd-yyyy HH:MM:ss

#### ToughJet API
##### Request
The request expected:

|Name|Description|
|---|---|
|from| 3 letter IATA code(eg. LHR, AMS)
|to| 3 letter IATA code(eg. LHR, AMS)
|departureDay| Day of the Month
|departureMonth| Month as an Integer(1-12)
|departureYear| 4 digit Year
|returnDay| Day of the Month
|returnMonth| Month as an Integer(1-12)
|returnYear| 4 digit Year
|numberOfAdults| Number of passengers

##### Response
The response provided by ToughJet contains a list of flights with the following attributes:

|Name|Description|
|---|---|
|carrier| Name of the Airline
|basePrice| Price without tax(doesn’t include discount)
|tax| Tax which needs to be charged along with the price
|discount| Discount which needs to be applied on the price(in percentage)
|departureAirportName| 3 letter IATA code(eg. LHR, AMS)
|arrivalAirportName| 3 letter IATA code(eg. LHR, AMS)
|departureDay| Day of the Month
|departureMonth| Month as an Integer(1-12)
|departureYear| 4 digit Year
|returnDay| Day of the Month
|returnMonth| Month as an Integer(1-12)
|returnYear| 4 digit Year

#### What you need to provide:
- A solution that meets the above requirements
- An application that can be started as a springboot application.
- Use Maven as the build manager.
