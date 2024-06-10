FROM node:14-alpine as build

WORKDIR /app

COPY package*.json ./

RUN npm install

RUN ls -la

COPY . .

RUN npm run build

FROM nginx:alpine

RUN ls -la

COPY --from=build /app/dist /usr/share/nginx/html

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]
