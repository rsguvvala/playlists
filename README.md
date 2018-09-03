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

## API Contract

### Get All PlayLists

This end point displays Playlists in the descending orders of Views.
Also supports pagination

```
curl http://host:port/music/playlists

```

### Get Playlists by Tag

This end point displays Playlists in the descending orders of Views.
Also supports pagination
```
curl http://host:port/music/playlists/{tag}

```
### Auto Suggest tags based on the query(tag)

To get suggestions for the query "pop"
```
curl http://host:port/music/playlists/suggestions?tag=pop

```

### Get Recommended tags 
These tags will be based on the appearance of the other tags along with the searched tag

To get recommended tags for "alternative"
```
curl http://host:port/music/playlists/recommendations?tag=alternative

```

### Ingest(Create) New Play List

## Design

Only Delivery API is implemented as the focus of the problem is on Deivery

<p align="center">
  <img src="./static/PlayLists%20Design.png" alt="Tests"
       width="654" height="450">
</p>

## Tests & Coverage

Most of business logic is around Service Layer and Custom Repository layer. There are 5 tests focussing these 2 areas.

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

IN PROGRESS
