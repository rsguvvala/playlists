Table of Contents
=================

      * [Setup Instructions](#setup-instructions)
         * [Prerequisites](#prerequisites)
            * [Install Elasticsearch](#install-elasticsearch)
            * [Install Kabana (Optional)](#install-kabana-optional)
         * [Start the API locally](#start-the-api-locally)
            * [Buid API](#buid-api)
            * [Start the API](#start-the-api)
      * [API Contract](#api-contract)
         * [Get All PlayLists](#get-all-playlists)
         * [Get Playlists by Tag](#get-playlists-by-tag)
         * [Auto Suggest tags based on the query(tag)](#auto-suggest-tags-based-on-the-querytag)
         * [Get Recommended tags](#get-recommended-tags)
         * [Ingest(Create) New Play List](#ingestcreate-new-play-list)
      * [Design](#design)
      * [Tests &amp; Coverage](#tests--coverage)
      * [Deployment](#deployment)
      
## Setup Instructions

### Prerequisites

#### Install Elasticsearch

Please follow https://www.elastic.co/guide/en/elasticsearch/guide/master/running-elasticsearch.html to setup elasticsearch.

Once the installation is complete, start the elastic search server as below

```
cd elasticsearch-<version>
./bin/elasticsearch 
```

#### Install Kabana (Optional)

Please follow https://www.elastic.co/guide/en/kibana/current/setup.html to setup Kibana


### Start the API locally

#### Buid API

mvn clean install

#### Start the API

```
java -jar target/play-tracks-0.0.1-SNAPSHOT.jar

```

## Demo & API Contract

API is hosted in AWS and available at http://api.rvala.com/

### Get All PlayLists

This end point displays Playlists in the descending orders of Views.
Also supports pagination

```
curl http://api.rvala.com/music/playlists

```

### Get Playlists by Tag

This end point displays Playlists in the descending orders of Views.
Also supports pagination
```
curl http://api.rvala.com/music/playlists/{tag}

```
### Auto Suggest tags based on the query(tag)

To get suggestions for the query "pop"
```
curl http://api.rvala.com/music/playlists/suggestions?tag=pop

```

### Get Recommended tags 
These tags will be based on the appearance of the other tags along with the searched tag

To get recommended tags for "alternative"
```
curl http://api.rvala.com/music/playlists/recommendations?tag=alternative

```


## Design

Only Delivery API is implemented as the focus of the problem is on Deivery

<p align="center">
  <img src="./static/PlayLists%20Design.png" alt="Tests"
       width="654" height="450">
</p>

## Tests & Coverage

Most of business logic is around Service Layer and Custom Repository layer. Following are the Tests focussing these 2 areas.

<p align="center">
  <img src="./static/play_lists_tests.png" alt="Tests"
       width="654" height="450">
</p>

Code coverage is above 80% (Rest is mostly controller layer)

<p align="center">
  <img src="./static/play_lists_code_coverage.png" alt="Tests"
       width="654" height="450">
</p>


## Deployment

API is deployed in AWS and available at http://api.rvala.com/
