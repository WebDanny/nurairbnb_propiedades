#!/bin/bash
hostname=$(curl http://147.182.164.95/metadata/v1/hostname)
docker run -d -p 80:80 --name pedidos-"$hostname" WebDanny:q/nurairbnb_propiedades:"$hostname"