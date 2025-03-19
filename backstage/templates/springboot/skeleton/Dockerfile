FROM registry.redhat.io/jboss-eap-8/eap8-openjdk17-builder-openshift-rhel8:1.0.0.GA AS builder

ENV GALLEON_PROVISION_FEATURE_PACKS org.jboss.eap:wildfly-ee-galleon-pack,org.jboss.eap.cloud:eap-cloud-galleon-pack
ENV GALLEON_PROVISION_LAYERS cloud-default-config
ENV GALLEON_PROVISION_CHANNELS org.jboss.eap.channels:eap-8.0

RUN /usr/local/s2i/assemble > /dev/null 2>&1


FROM registry.redhat.io/jboss-eap-8/eap8-openjdk17-runtime-openshift-rhel8:1.0.0.GA AS runtime
USER root
ENV TZ=America/Mexico_City
RUN ln -fs /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

COPY --from=builder --chown=jboss:root $JBOSS_HOME $JBOSS_HOME
COPY --chown=jboss:root target/*.war $JBOSS_HOME/standalone/deployments
RUN chmod -R ug+rwX $JBOSS_HOME && chmod 644 $JAVA_HOME/lib/security/cacerts

USER jboss