# Usa uma imagem Node
FROM node:20-alpine

# Define o diretório de trabalho
WORKDIR /app

# Copia package.json e yarn.lock
COPY package.json yarn.lock ./

# Instala dependências
RUN yarn install --frozen-lockfile

# Copia o restante do código
COPY . .

# Expõe a porta do dev server (React padrão: 3000)
EXPOSE 3000

# Comando para rodar em dev
CMD ["yarn", "dev", "--host", "0.0.0.0"]
