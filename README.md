# Pica Pau Executor — projeto Android inicial

Projeto Android nativo em Kotlin + Jetpack Compose, com tema neon roxo.

## O que já existe
- Nome e tela inicial Pica Pau Executor.
- Criação automática de `files/PicaPau/` na primeira abertura.
- Arquivos `config.json`, `key.json` e pasta `images/`.
- Campo de entrada visual para Key.

## Limitações desta versão
Este é um protótipo de interface e armazenamento local. A tela não valida licenças
nem executa scripts Roblox. A validade de 7 dias está apenas registrada como
configuração inicial; a validação real precisa de um serviço de licenças.

## Gerar APK
1. Abra a pasta no Android Studio.
2. Aguarde a sincronização do Gradle.
3. Configure um Android SDK (API 35).
4. Selecione Build > Build Bundle(s) / APK(s) > Build APK(s).
5. O APK de debug ficará em `app/build/outputs/apk/debug/app-debug.apk`.
