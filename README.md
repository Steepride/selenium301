# Selenium 301 Sauce Labs Training Course
The slide deck was written in reveal.js

### Start Me!
In order to bring up the presentation - there are couple of things you can do.

#### Easiest:
* simply go into the directory and load the sauceEnterprise.html file in your browser. (Double clicking on it should bring it up in a browser right away)

#### Easy (if you have python installed):
* go into the folder/direfctory in a terminal
* run python -m SimpleHTTPServer
* open a browser and go to localhost:8000/selenium301.html

#### Medium (if you have nginx installed):
* go into the /etc/conf/conf.d directory
* create a new file called train.conf
* insert the following lines:
```
server {
   listen 8000;
   root /path/to/the/presentation_folder;
}
```

* then reload the config:
```
$ nginx -s reload
```

You can access the presentation at localhost:8000/selenium301.html

### How to Use the Labs
To import the lab files into your environment you can either:

1. Clone the project into your local machine and import them into your workspace via Maven Project

2. Download the pacakge as a zip file and import into your workspace via Maven Project


### Lab Resources

#### [Advanced Page Objects] ()
#### [Testable Code] ()
#### [Jenkins Pull Request Build (DEMO)] ()