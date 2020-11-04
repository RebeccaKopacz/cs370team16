FROM ubuntu:latest

RUN apt-get update
RUN apt-get install curl -y
RUN git clone https://github.com/RebeccaKopacz/cs370team16.git

CMD "curl"