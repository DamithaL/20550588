package ezbus.mit20550588.conductor.util;

import android.app.Application;
import android.util.Log;

import com.stripe.android.PaymentConfiguration;

import java.io.InputStream;
import java.security.KeyStore;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

import ezbus.mit20550588.conductor.R;

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        UserStateManager.init(getApplicationContext());

        // Initialize the Stripe SDK
        PaymentConfiguration.init(
                getApplicationContext(),
                "pk_test_51OQMzRK8hceL936mDtIHEiYc5waHaEEgk38PT2gvZAhoKRq3cnkDckasE8LgOSVSCQLsCzIVb6mSm4QUbFAxBg5g00KdBLGVRK"
        );


        try {

            Log.d("MyApp","CERTIFICATION");
            // Load self-signed certificate into truststore
            InputStream certInputStream = getResources().openRawResource(R.raw.localhost);
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            X509Certificate cert = (X509Certificate) cf.generateCertificate(certInputStream);

            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null, null);
            keyStore.setCertificateEntry("custom_cert", cert);

            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, trustManagerFactory.getTrustManagers(), null);

            HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
