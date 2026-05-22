package net.thunderbird.android.auth

import net.thunderbird.android.BuildConfig
import net.thunderbird.core.common.oauth.OAuthConfiguration
import net.thunderbird.core.common.oauth.OAuthConfigurationFactory

@Suppress("ktlint:standard:max-line-length")
class TbOAuthConfigurationFactory : OAuthConfigurationFactory {
    override fun createConfigurations(): Map<List<String>, OAuthConfiguration> {
        return mapOf(
            createAolConfiguration(),
            createGmailConfiguration(),
            createFastmailConfiguration(),
            createMicrosoftConfiguration(),
            createYahooConfiguration(),
            createThundermailConfiguration(),
            createThundermailStageConfiguration(),
        )
    }

    private fun createAolConfiguration(): Pair<List<String>, OAuthConfiguration> {
        return listOf(
            "imap.aol.com",
            "smtp.aol.com",
        ) to OAuthConfiguration(
            clientId = "YOUR_AOL_CLIENT_ID",
            scopes = listOf("mail-w"),
            authorizationEndpoint = "https://api.login.aol.com/oauth2/request_auth",
            tokenEndpoint = "https://api.login.aol.com/oauth2/get_token",
            redirectUri = "${BuildConfig.APPLICATION_ID}://oauth2redirect",
        )
    }

    private fun createFastmailConfiguration(): Pair<List<String>, OAuthConfiguration> {
        return listOf(
            "imap.fastmail.com",
            "smtp.fastmail.com",
        ) to OAuthConfiguration(
            clientId = "YOUR_FASTMAIL_CLIENT_ID",
            scopes = listOf("https://www.fastmail.com/dev/protocol-imap", "https://www.fastmail.com/dev/protocol-smtp"),
            authorizationEndpoint = "https://api.fastmail.com/oauth/authorize",
            tokenEndpoint = "https://api.fastmail.com/oauth/refresh",
            redirectUri = "${BuildConfig.APPLICATION_ID}://oauth2redirect",
        )
    }

    private fun createGmailConfiguration(): Pair<List<String>, OAuthConfiguration> {
        return listOf(
            "imap.gmail.com",
            "imap.googlemail.com",
            "smtp.gmail.com",
            "smtp.googlemail.com",
        ) to OAuthConfiguration(
            clientId = "YOUR_GMAIL_CLIENT_ID",
            scopes = listOf("https://mail.google.com/"),
            authorizationEndpoint = "https://accounts.google.com/o/oauth2/v2/auth",
            tokenEndpoint = "https://oauth2.googleapis.com/token",
            redirectUri = "${BuildConfig.APPLICATION_ID}:/oauth2redirect",
        )
    }

    private fun createMicrosoftConfiguration(): Pair<List<String>, OAuthConfiguration> {
        return listOf(
            "outlook.office365.com",
            "smtp.office365.com",
            "smtp-mail.outlook.com",
        ) to OAuthConfiguration(
            clientId = "YOUR_MICROSOFT_CLIENT_ID",
            scopes = listOf(
                "profile",
                "openid",
                "email",
                "https://outlook.office.com/IMAP.AccessAsUser.All",
                "https://outlook.office.com/SMTP.Send",
                "offline_access",
            ),
            authorizationEndpoint = "https://login.microsoftonline.com/common/oauth2/v2.0/authorize",
            tokenEndpoint = "https://login.microsoftonline.com/common/oauth2/v2.0/token",
            redirectUri = "YOUR_MICROSOFT_REDIRECT_URI",
        )
    }

    private fun createYahooConfiguration(): Pair<List<String>, OAuthConfiguration> {
        return listOf(
            "imap.mail.yahoo.com",
            "smtp.mail.yahoo.com",
        ) to OAuthConfiguration(
            clientId = "YOUR_YAHOO_CLIENT_ID",
            scopes = listOf("mail-w"),
            authorizationEndpoint = "https://api.login.yahoo.com/oauth2/request_auth",
            tokenEndpoint = "https://api.login.yahoo.com/oauth2/get_token",
            redirectUri = "${BuildConfig.APPLICATION_ID}://oauth2redirect",
        )
    }

    private fun createThundermailConfiguration(): Pair<List<String>, OAuthConfiguration> =
        listOf(
            "mail.tb.pro",
            "mail.thundermail.com",
        ) to OAuthConfiguration(
            clientId = "YOUR_THUNDERMAIL_CLIENT_ID",
            scopes = listOf("openid", "profile", "email", "offline_access"),
            authorizationEndpoint = "https://auth.tb.pro/realms/tbpro/protocol/openid-connect/auth",
            tokenEndpoint = "https://auth.tb.pro/realms/tbpro/protocol/openid-connect/token",
            redirectUri = "${BuildConfig.APPLICATION_ID}://oauth2redirect",
        )

    private fun createThundermailStageConfiguration(): Pair<List<String>, OAuthConfiguration> =
        listOf(
            "mail.stage-thundermail.com",
        ) to OAuthConfiguration(
            clientId = "YOUR_THUNDERMAIL_STAGE_CLIENT_ID",
            scopes = listOf("openid", "profile", "email", "offline_access"),
            authorizationEndpoint = "https://auth-stage.tb.pro/realms/tbpro/protocol/openid-connect/auth",
            tokenEndpoint = "https://auth-stage.tb.pro/realms/tbpro/protocol/openid-connect/token",
            redirectUri = "${BuildConfig.APPLICATION_ID}://oauth2redirect",
        )
}
