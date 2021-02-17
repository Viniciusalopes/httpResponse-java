/*
 *  License   : MIT - Copyright 2021 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Author    : Vinicius Lopes
 *  Date      : 17/02/2021 01:08:05 
 *  Project   : HttpResponseJava
 *  Version   : 0.0.1
 *  Purpose   :
 *  Changelog : 2020-01-00 v.0.0.2 (Vinicius Lopes)
 */
package br.com.vovolinux.httpresponsejava;

/**
 *
 * @author vovostudio
 */
public class AppHttpResponse {

    private static HttpResponse ret;

    public static HttpResponse handleException(Exception e, HttpResponse response) throws Exception {
        try {
            ret = getByStatusCode(Integer.parseInt(getErrorMessage(e).split("_")[0]));
        } catch (Exception ex) {
            ret = getByStatusCode(406);
        }
        ret.setRequest(response.getRequest());
        ret.setData(response.getData());
        ret.setDetails(getErrorMessage(e).replace(ret.getStatusCode() + "_", ""));

        return ret;
    }

    /**
     * Obtém um texto sobre o motivo da Exception.
     *
     * @param e Exception para obter o texto da mensagem.
     * @return
     */
    public static String getErrorMessage(Exception e) {
        return (e.getMessage() != null) ? e.getMessage()
                : ((e.getCause() != null) ? e.getCause().getMessage()
                : ((e.getLocalizedMessage() != null) ? e.getLocalizedMessage() : e.getStackTrace().toString()));
    }

    public static HttpResponse getByStatusCode(int status_code) {
        ret = new HttpResponse(status_code);

        switch (status_code) {
            case 100:
                ret.setTypeResponse("Informação");
                ret.setResponse("Continue");
                ret.setDetails("Essa resposta provisória indica que tudo ocorreu bem até agora e que o cliente deve continuar com a requisição ou ignorar se já concluiu o que gostaria.");
                break;

            case 101:
                ret.setTypeResponse("Informação");
                ret.setResponse("Switching Protocol");
                ret.setDetails("Esse código é enviado em resposta a um cabeçalho de solicitação Upgrade pelo cliente, e indica o protocolo a que o servidor está alternando.");
                break;

            case 102:
                ret.setTypeResponse("Informação");
                ret.setResponse("Processing (WebDAV)");
                ret.setDetails("Este código indica que o servidor recebeu e está processando a requisição, mas nenhuma resposta está disponível ainda.");
                break;

            case 103:
                ret.setTypeResponse("Informação");
                ret.setResponse("Early Hints");
                ret.setDetails("Este código tem principalmente o objetivo de ser utilizado com o cabeçalho Link, indicando que o agente deve iniciar a pré-carregar recursos enquanto o servidor prepara uma resposta.");
                break;

            case 200:
                ret.setTypeResponse("Sucesso");
                ret.setResponse("OK");
                ret.setDetails("Esta requisição foi bem sucedida. O significado do sucesso varia de acordo com o método HTTP:");
                break;

            case 201:
                ret.setTypeResponse("Sucesso");
                ret.setResponse("Created");
                ret.setDetails("A requisição foi bem sucedida e um novo recurso foi criado como resultado. Esta é uma tipica resposta enviada após uma requisição POST.");
                break;

            case 202:
                ret.setTypeResponse("Sucesso");
                ret.setResponse("Accepted");
                ret.setDetails("A requisição foi recebida mas nenhuma ação foi tomada sobre ela. Isto é uma requisição não-comprometedora, o que significa que não há nenhuma maneira no HTTP para enviar uma resposta assíncrona indicando o resultado do processamento da solicitação. Isto é");
                break;

            case 203:
                ret.setTypeResponse("Sucesso");
                ret.setResponse("Non-Authoritative Information");
                ret.setDetails("Esse código de resposta significa que o conjunto de meta-informações retornadas não é o conjunto exato disponível no servidor de origem, mas coletado de uma cópia local ou de terceiros. Exceto essa condição, a resposta de 200 OK deve ser preferida em vez ");
                break;

            case 204:
                ret.setTypeResponse("Sucesso");
                ret.setResponse("No Content");
                ret.setDetails("Não há conteúdo para enviar para esta solicitação, mas os cabeçalhos podem ser úteis. O user-agent pode atualizar seus cabeçalhos em cache para este recurso com os novos.");
                break;

            case 205:
                ret.setTypeResponse("Sucesso");
                ret.setResponse("Reset Content");
                ret.setDetails("Esta requisição é enviada após realizanda a solicitação para informar ao user agent redefinir a visualização do documento que enviou essa solicitação.");
                break;

            case 206:
                ret.setTypeResponse("Sucesso");
                ret.setResponse("Partial Content");
                ret.setDetails("Esta resposta é usada por causa do cabeçalho de intervalo enviado pelo cliente para separar o download em vários fluxos.");
                break;

            case 207:
                ret.setTypeResponse("Sucesso");
                ret.setResponse("Multi-Status (WebDAV)");
                ret.setDetails("Uma resposta Multi-Status transmite informações sobre vários recursos em situações em que vários códigos de status podem ser apropriados.");
                break;

            case 208:
                ret.setTypeResponse("Sucesso");
                ret.setResponse("Multi-Status (WebDAV Tag)");
                ret.setDetails("Usado dentro de um elemento de resposta <dav:propstat> para evitar enumerar os membros internos de várias ligações à mesma coleção repetidamente.");
                break;

            case 226:
                ret.setTypeResponse("Sucesso");
                ret.setResponse("IM Used (HTTP Delta encoding)");
                ret.setDetails("O servidor cumpriu uma solicitação GET para o recurso e a resposta é uma representação do resultado de uma ou mais manipulações de instância aplicadas à instância atual.");
                break;

            case 300:
                ret.setTypeResponse("Redirecionamento");
                ret.setResponse("Multiple Choice");
                ret.setDetails("A requisição tem mais de uma resposta possível. User-agent ou o user deve escolher uma delas. Não há maneira padrão para escolher uma das respostas.");
                break;

            case 301:
                ret.setTypeResponse("Redirecionamento");
                ret.setResponse("Moved Permanently");
                ret.setDetails("Esse código de resposta significa que a URI do recurso requerido mudou. Provavelmente, a nova URI será especificada na resposta.");
                break;

            case 302:
                ret.setTypeResponse("Redirecionamento");
                ret.setResponse("Found");
                ret.setDetails("Esse código de resposta significa que a URI do recurso requerido foi mudada temporariamente. Novas mudanças na URI poderão ser feitas no futuro. Portanto, a mesma URI deve ser usada pelo cliente em requisições futuras.");
                break;

            case 303:
                ret.setTypeResponse("Redirecionamento");
                ret.setResponse("See Other");
                ret.setDetails("O servidor manda essa resposta para instruir ao cliente buscar o recurso requisitado em outra URI com uma requisição GET.");
                break;

            case 304:
                ret.setTypeResponse("Redirecionamento");
                ret.setResponse("Not Modified");
                ret.setDetails("Essa resposta é usada para questões de cache. Diz ao cliente que a resposta não foi modificada. Portanto, o cliente pode usar a mesma versão em cache da resposta.");
                break;

            case 305:
                ret.setTypeResponse("Redirecionamento");
                ret.setResponse("Use Proxy");
                ret.setDetails("Foi definida em uma versão anterior da especificação HTTP para indicar que uma resposta deve ser acessada por um proxy. Foi depreciada por questões de segurança em respeito a configuração em banda de um proxy.");
                break;

            case 306:
                ret.setTypeResponse("Redirecionamento");
                ret.setResponse("unused");
                ret.setDetails("Esse código de resposta não é mais utilizado, encontra-se reservado. Foi usado numa versão anterior da especificação HTTP 1.1.");
                break;

            case 307:
                ret.setTypeResponse("Redirecionamento");
                ret.setResponse("Temporary Redirect");
                ret.setDetails("O servidor mandou essa resposta direcionando o cliente a buscar o recurso requisitado em outra URI com o mesmo método que foi utilizado na requisição original. Tem a mesma semântica do código 302 Found, com a exceção de que o user-agent não deve mudar o m");
                break;

            case 308:
                ret.setTypeResponse("Redirecionamento");
                ret.setResponse("Permanent Redirect");
                ret.setDetails("Esse código significa que o recurso agora está permanentemente localizado em outra URI, especificada pelo cabeçalho de resposta Location. Tem a mesma semântica do código de resposta HTTP 301 Moved Permanently  com a exceção de que o user-agent não deve mu");
                break;

            case 400:
                ret.setTypeResponse("Erro do cliente");
                ret.setResponse("Bad Request");
                ret.setDetails("Essa resposta significa que o servidor não entendeu a requisição pois está com uma sintaxe inválida.");
                break;

            case 401:
                ret.setTypeResponse("Erro do cliente");
                ret.setResponse("Unauthorized");
                ret.setDetails("Embora o padrão HTTP especifique \"unauthorized\", semanticamente, essa resposta significa \"unauthenticated\". Ou seja, o cliente deve se autenticar para obter a resposta solicitada.");
                break;

            case 402:
                ret.setTypeResponse("Erro do cliente");
                ret.setResponse("Payment Required");
                ret.setDetails("Este código de resposta está reservado para uso futuro. O objetivo inicial da criação deste código era usá-lo para sistemas digitais de pagamento porém ele não está sendo usado atualmente.");
                break;

            case 403:
                ret.setTypeResponse("Erro do cliente");
                ret.setResponse("Forbidden");
                ret.setDetails("O cliente não tem direitos de acesso ao conteúdo portanto o servidor está rejeitando dar a resposta. Diferente do código 401, aqui a identidade do cliente é conhecida.");
                break;

            case 404:
                ret.setTypeResponse("Erro do cliente");
                ret.setResponse("Not Found");
                ret.setDetails("O servidor não pode encontrar o recurso solicitado. Este código de resposta talvez seja o mais famoso devido à frequência com que acontece na web.");
                break;

            case 405:
                ret.setTypeResponse("Erro do cliente");
                ret.setResponse("Method Not Allowed");
                ret.setDetails("O método de solicitação é conhecido pelo servidor, mas foi desativado e não pode ser usado. Os dois métodos obrigatórios, GET e HEAD, nunca devem ser desabilitados e não devem retornar este código de erro.");
                break;

            case 406:
                ret.setTypeResponse("Erro do cliente");
                ret.setResponse("Not Acceptable");
                ret.setDetails("Essa resposta é enviada quando o servidor da Web após realizar a negociação de conteúdo orientada pelo servidor, não encontra nenhum conteúdo seguindo os critérios fornecidos pelo agente do usuário.");
                break;

            case 407:
                ret.setTypeResponse("Erro do cliente");
                ret.setResponse("Proxy Authentication Required");
                ret.setDetails("Semelhante ao 401 porem é necessário que a autenticação seja feita por um proxy.");
                break;

            case 408:
                ret.setTypeResponse("Erro do cliente");
                ret.setResponse("Request Timeout");
                ret.setDetails("Esta resposta é enviada por alguns servidores em uma conexão ociosa, mesmo sem qualquer requisição prévia pelo cliente. Ela significa que o servidor gostaria de derrubar esta conexão em desuso. Esta resposta é muito usada já que alguns navegadores, como C");
                break;

            case 409:
                ret.setTypeResponse("Erro do cliente");
                ret.setResponse("Conflict");
                ret.setDetails("Esta resposta será enviada quando uma requisição conflitar com o estado atual do servidor.");
                break;

            case 410:
                ret.setTypeResponse("Erro do cliente");
                ret.setResponse("Gone");
                ret.setDetails("Esta resposta será enviada quando o conteúdo requisitado foi permanentemente deletado do servidor, sem nenhum endereço de redirecionamento. É experado que clientes removam seus caches e links para o recurso. A especificação HTTP espera que este código de ");
                break;

            case 411:
                ret.setTypeResponse("Erro do cliente");
                ret.setResponse("Length Required");
                ret.setDetails("O servidor rejeitou a requisição porque o campo Content-Length do cabeçalho não está definido e o servidor o requer.");
                break;

            case 412:
                ret.setTypeResponse("Erro do cliente");
                ret.setResponse("Precondition Failed");
                ret.setDetails("O cliente indicou nos seus cabeçalhos pré-condições que o servidor não atende.");
                break;

            case 413:
                ret.setTypeResponse("Erro do cliente");
                ret.setResponse("Payload Too Large");
                ret.setDetails("A entidade requisição é maior do que os limites definidos pelo servidor; o servidor pode fechar a conexão ou retornar um campo de cabeçalho Retry-After.");
                break;

            case 414:
                ret.setTypeResponse("Erro do cliente");
                ret.setResponse("URI Too Long");
                ret.setDetails("A URI requisitada pelo cliente é maior do que o servidor aceita para interpretar.");
                break;

            case 415:
                ret.setTypeResponse("Erro do cliente");
                ret.setResponse("Unsupported Media Type");
                ret.setDetails("O formato de mídia dos dados requisitados não é suportado pelo servidor, então o servidor rejeita a requisição.");
                break;

            case 416:
                ret.setTypeResponse("Erro do cliente");
                ret.setResponse("Requested Range Not Satisfiable");
                ret.setDetails("O trecho especificado pelo campo Range do cabeçalho na requisição não pode ser preenchido; é possível que o trecho esteja fora do tamanho dos dados da URI alvo.");
                break;

            case 417:
                ret.setTypeResponse("Erro do cliente");
                ret.setResponse("Expectation Failed");
                ret.setDetails("Este código de resposta significa que a expectativa indicada pelo campo Expect do cabeçalho da requisição não pode ser satisfeita pelo servidor.");
                break;

            case 418:
                ret.setTypeResponse("Erro do cliente");
                ret.setResponse("I\"m a teapot");
                ret.setDetails("O servidor recusa a tentativa de coar café num bule de chá.");
                break;

            case 421:
                ret.setTypeResponse("Erro do cliente");
                ret.setResponse("Misdirected Request");
                ret.setDetails("A requisição foi direcionada a um servidor inapto a produzir a resposta. Pode ser enviado por um servidor que não está configurado para produzir respostas para a combinação de esquema (\"scheme\") e autoridade inclusas na URI da requisição.");
                break;

            case 422:
                ret.setTypeResponse("Erro do cliente");
                ret.setResponse("Unprocessable Entity (WebDAV)");
                ret.setDetails("A requisição está bem formada mas inabilitada para ser seguida devido a erros semânticos.");
                break;

            case 423:
                ret.setTypeResponse("Erro do cliente");
                ret.setResponse("Locked (WebDAV)");
                ret.setDetails("O recurso sendo acessado está travado.");
                break;

            case 424:
                ret.setTypeResponse("Erro do cliente");
                ret.setResponse("Failed Dependency (WebDAV)");
                ret.setDetails("A requisição falhou devido a falha em requisição prévia.");
                break;

            case 425:
                ret.setTypeResponse("Erro do cliente");
                ret.setResponse("Too Early");
                ret.setDetails("Indica que o servidor não está disposto a arriscar processar uma requisição que pode ser refeita.");
                break;

            case 426:
                ret.setTypeResponse("Erro do cliente");
                ret.setResponse("Upgrade Required");
                ret.setDetails("O servidor se recusa a executar a requisição usando o protocolo corrente mas estará pronto a fazê-lo após o cliente atualizar para um protocolo diferente. O servidor envia um cabeçalho Upgrade numa resposta 426 para indicar o(s) protocolo(s) requeridos.");
                break;

            case 428:
                ret.setTypeResponse("Erro do cliente");
                ret.setResponse("Precondition Required");
                ret.setDetails("O servidor de origem requer que a resposta seja condicional. Feito para prevenir o problema da \"atualização perdida\", onde um cliente pega o estado de um recurso (GET) , modifica-o, e o põe de volta no servidor (PUT), enquanto um terceiro modificou o esta");
                break;

            case 429:
                ret.setTypeResponse("Erro do cliente");
                ret.setResponse("Too Many Requests");
                ret.setDetails("O usuário enviou muitas requisições num dado tempo (limitação de frequência).");
                break;

            case 431:
                ret.setTypeResponse("Erro do cliente");
                ret.setResponse("Request Header Fields Too Large");
                ret.setDetails("O servidor não quer processar a requisição porque os campos de cabeçalho são muito grandes. A requisição PODE ser submetida novemente depois de reduzir o tamanho dos campos de cabeçalho.");
                break;

            case 451:
                ret.setTypeResponse("Erro do cliente");
                ret.setResponse("Unavailable For Legal Reasons");
                ret.setDetails("O usuário requisitou um recurso ilegal, tal como uma página censurada por um governo.");
                break;

            case 500:
                ret.setTypeResponse("Erro do servidor");
                ret.setResponse("Internal Server Error");
                ret.setDetails("O servidor encontrou uma situação com a qual não sabe lidar.");
                break;

            case 501:
                ret.setTypeResponse("Erro do servidor");
                ret.setResponse("Not Implemented");
                ret.setDetails("O método da requisição não é suportado pelo servidor e não pode ser manipulado. Os únicos métodos exigidos que servidores suportem (e portanto não devem retornar este código) são GET e HEAD.");
                break;

            case 502:
                ret.setTypeResponse("Erro do servidor");
                ret.setResponse("Bad Gateway");
                ret.setDetails("Esta resposta de erro significa que o servidor, ao trabalhar como um gateway a fim de obter uma resposta necessária para manipular a requisição, obteve uma resposta inválida.");
                break;

            case 503:
                ret.setTypeResponse("Erro do servidor");
                ret.setResponse("Service Unavailable");
                ret.setDetails("O servidor não está pronto para manipular a requisição. Causas comuns são um servidor em manutenção ou sobrecarregado. Note que junto a esta resposta, uma página amigável explicando o problema deveria ser enviada. Estas respostas devem ser usadas para con");
                break;

            case 504:
                ret.setTypeResponse("Erro do servidor");
                ret.setResponse("Gateway Timeout");
                ret.setDetails("Esta resposta de erro é dada quando o servidor está atuando como um gateway e não obtém uma resposta à tempo.");
                break;

            case 505:
                ret.setTypeResponse("Erro do servidor");
                ret.setResponse("HTTP Version Not Supported");
                ret.setDetails("A versão HTTP usada na requisição não é suportada pelo servidor.");
                break;

            case 506:
                ret.setTypeResponse("Erro do servidor");
                ret.setResponse("Variant Also Negotiates");
                ret.setDetails("O servidor tem um erro de configuração interno: a negociação transparente de conteúdo para a requisição resulta em uma referência circular.");
                break;

            case 507:
                ret.setTypeResponse("Erro do servidor");
                ret.setResponse("Insufficient Storage");
                ret.setDetails("O servidor tem um erro interno de configuração: o recurso variante escolhido está configurado para entrar em negociação transparente de conteúdo com ele mesmo, e portanto não é uma ponta válida no processo de negociação.");
                break;

            case 508:
                ret.setTypeResponse("Erro do servidor");
                ret.setResponse("Loop Detected (WebDAV)");
                ret.setDetails("O servidor detectou um looping infinito ao processar a requisição.");
                break;

            case 510:
                ret.setTypeResponse("Erro do servidor");
                ret.setResponse("Not Extended");
                ret.setDetails("Exigem-se extenções posteriores à requisição para o servidor atendê-la.");
                break;

            case 511:
                ret.setTypeResponse("Erro do servidor");
                ret.setResponse("Network Authentication Required");
                ret.setDetails("O código de status 511 indica que o cliente precisa se autenticar para ganhar acesso à rede.");
                break;
        }
        return ret;
    }
}
