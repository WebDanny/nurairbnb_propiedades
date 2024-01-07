#!/bin/bash
hostname=$(curl http://64.227.8.219/metadata/v1/hostname)
docker run -d -p 80:80 --name propiedades-"$hostname" WebDanny:q/nurairbnb_propiedades:"$hostname"