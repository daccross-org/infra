FROM registry.access.redhat.com/ubi9/nginx-122:9.5-1739784317
COPY --chown=1001 dist/frontend .
COPY --chown=1001 nginx.conf "${NGINX_CONF_PATH}"
EXPOSE 80
USER 1001
CMD ["nginx"]