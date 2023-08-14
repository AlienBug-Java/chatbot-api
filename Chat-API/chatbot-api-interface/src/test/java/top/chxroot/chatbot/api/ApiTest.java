package top.chxroot.chatbot.api;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

/**
 * @author 陈红祥
 */

public class ApiTest {

    @Test
    public void query_unnamed_question() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        String url = "https://api.zsxq.com/v2/groups/28885518425541/topics?scope=digests&count=20";
        HttpGet httpGet = new HttpGet(url);
        httpGet.addHeader("cookie","zsxq_access_token=B44DA7E5-63DB-8910-C94F-45189D3F186A_05F96CF35CEEE3E3; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22189a1a550a7584-0d9f6dea3a4b268-7c546c76-850468-189a1a550a86c2%22%2C%22first_id%22%3A%22%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg5YTFhNTUwYTc1ODQtMGQ5ZjZkZWEzYTRiMjY4LTdjNTQ2Yzc2LTg1MDQ2OC0xODlhMWE1NTBhODZjMiJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%22%2C%22value%22%3A%22%22%7D%2C%22%24device_id%22%3A%22189a1a550a7584-0d9f6dea3a4b268-7c546c76-850468-189a1a550a86c2%22%7D; abtest_env=product; zsxqsessionid=6be58c6b90ebafd0ed861a0cf524b612");
        httpGet.addHeader("Content-Type","application/json, text/plain, */*");
        CloseableHttpResponse response = httpClient.execute(httpGet);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void ans() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        String url = "https://api.zsxq.com/v2/topics/411854441524588/comments";
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader("cookie","zsxq_access_token=B44DA7E5-63DB-8910-C94F-45189D3F186A_05F96CF35CEEE3E3; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22189a1a550a7584-0d9f6dea3a4b268-7c546c76-850468-189a1a550a86c2%22%2C%22first_id%22%3A%22%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg5YTFhNTUwYTc1ODQtMGQ5ZjZkZWEzYTRiMjY4LTdjNTQ2Yzc2LTg1MDQ2OC0xODlhMWE1NTBhODZjMiJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%22%2C%22value%22%3A%22%22%7D%2C%22%24device_id%22%3A%22189a1a550a7584-0d9f6dea3a4b268-7c546c76-850468-189a1a550a86c2%22%7D; abtest_env=product; zsxqsessionid=6be58c6b90ebafd0ed861a0cf524b612");
        httpPost.addHeader("Content-Type","application/json, text/plain, */*");
        String param = "{\"req_data\":{\"text\":\"我不会\\n\",\"image_ids\":[],\"mentioned_user_ids\":[]}}";
        StringEntity entity = new StringEntity(param, ContentType.create("text/json", "UTF-8") );
        httpPost.setEntity(entity);
        CloseableHttpResponse response = httpClient.execute(httpPost);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }
}
