# Levantar PostgreSQL con Docker Compose
echo "Iniciando PostgreSQL con Docker Compose..."
docker-compose up -d postgres

# Esperar unos segundos para asegurarse de que PostgreSQL esté completamente iniciado
echo "Esperando 10 segundos para que PostgreSQL se inicie..."
sleep 10

# Instalar dependencias y construir el frontend
echo "Instalando dependencias y construyendo el frontend..."
# cd frontend
# npm install
# npm run build
# cd ..

# Instalar dependencias y construir el backend
echo "Instalando dependencias y construyendo el backend..."
cd backend
./gradlew build

docker-compose up -d


echo "Configuración completada."