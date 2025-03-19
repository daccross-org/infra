FROM oxzacrmdps01.azurecr.io/jboss-eap8-base:1.0.0
USER root
COPY --chown=jboss:root target/*.war $JBOSS_HOME/standalone/deployments
RUN chmod -R ug+rwX $JBOSS_HOME && chmod 644 $JAVA_HOME/lib/security/cacerts
USER jboss