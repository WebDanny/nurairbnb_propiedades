#!/bin/bash
hostname=$(curl http://147.182.164.95/metadata/v1/hostname)
docker run -d -p 80:80 --name propiedades-"$hostname" webdanny/nurairbnb_propiedades:"$hostname"