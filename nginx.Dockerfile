FROM nginx:alpine

COPY ./resources/static /opt/jirarush/resources/static

COPY ./resources/mails /opt/jirarush/resources/mails

COPY ./resources/robots.txt /opt/jirarush/resources/robots.txt

COPY ./config/nginx.conf /etc/nginx/nginx.conf
