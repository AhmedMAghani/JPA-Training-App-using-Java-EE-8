# Build
mvn clean package && docker build -t org.example/JPAJakartaEE8 .

# RUN

docker rm -f JPAJakartaEE8 || true && docker run -d -p 8080:8080 -p 4848:4848 --name JPAJakartaEE8 org.example/JPAJakartaEE8 