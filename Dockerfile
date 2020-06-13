FROM airhacks/glassfish
COPY ./target/JPAJakartaEE8.war ${DEPLOYMENT_DIR}
