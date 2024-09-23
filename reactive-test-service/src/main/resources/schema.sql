CREATE TABLE bandas_metal (
                              id SERIAL PRIMARY KEY,
                              nome VARCHAR(255),
                              origem VARCHAR(255),
                              ano_formacao INT,
                              genero_principal VARCHAR(255),
                              ativa BOOLEAN,
                              site_oficial VARCHAR(255)
);