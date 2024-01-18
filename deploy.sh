#!/bin/bash
hostname=$(curl http://169.254.169.254/metadata/v1/hostname)
docker run -d -p 9091:8080 --name propiedades-"$hostname" dannyhs/propiedades:"$hostname"