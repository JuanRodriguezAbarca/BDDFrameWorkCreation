package testingRESTexamples;

import com.jayway.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.cert.Certificate;

import static com.jayway.restassured.RestAssured.get;

/**
 * Created by Juan_Rodriguez on 8/10/2015.
 */
public class HTTPClientPorcuilo {



        protected static final Logger LOG = LoggerFactory.getLogger(HTTPClientPorcuilo.class);


        public void testingHttpClient() {

            String given_url = "http://restcountries.eu/rest/v1/all";
            URL url;

            try {
                url = new URL(given_url);

                if (given_url.startsWith("https")) {

                    HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

                    print_https_cert(con);

                    print_https_content(con);
                } else if (given_url.startsWith("http")) {

                    HttpURLConnection con = (HttpURLConnection) url.openConnection();

                    print_http_cert(con);

                    print_http_content(con);

                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void print_https_cert(HttpsURLConnection con) {
            if (con != null) {
                try {
                    System.out.println("\n");
                    System.out.println("Response Code: " + con.getResponseCode());
                    System.out.println("Cipher Suite: " + con.getCipherSuite());
                    System.out.println("\n");

                    Certificate[] certs = con.getServerCertificates();
                    for (Certificate cert : certs) {
                        System.out.println("Cert type: " + cert.getType());
                        System.out.println("Cert Hash Code: " + cert.hashCode());
                        System.out.println("Cert Public Key Algorithm: "
                                + cert.getPublicKey().getAlgorithm());
                        System.out.println("Cert Public Key Format: "
                                + cert.getPublicKey().getFormat());
                        System.out.println("\n");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        private void print_http_cert(HttpURLConnection con) {
            if (con != null) {
                try {
                    System.out.println("\n");
                    System.out.println("Response Code: " + con.getResponseCode());
                    System.out.println("\n");


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        private void print_http_content(HttpURLConnection con) {
            if (con != null) {
                try {
                    System.out.println("************** Content of the URL************");
                    Response response = get(con.getURL());
                    JSONArray jsonResponse = new JSONArray(response.asString());

                    String input;
                    int i = 0;

                    try {
                        while ((input = jsonResponse.getJSONObject(i).toString()) != null) {
                            System.out.println(input);
                            i++;
                        }
                    } catch (JSONException e){
                        LOG.info("JSONException catched: "+e.getMessage());
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        private void print_https_content(HttpsURLConnection con) {
            if (con != null) {
                try {
                    System.out.println("************** Content of the URL************");
                    BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

                    String input;

                    while ((input = br.readLine()) != null) {
                        System.out.println(input);
                    }
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }





