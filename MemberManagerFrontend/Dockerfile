FROM node:18-buster-slim as node

WORKDIR /app

COPY . .

RUN npm install
RUN npm run build

FROM nginx:alpine
COPY --from=node /app/dist/member-manager-frontend /usr/share/nginx/html
