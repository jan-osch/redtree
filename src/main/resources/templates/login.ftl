<#import "skeleton.ftl" as skeleton>
<@skeleton.page title="Login">
<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="error" type="java.util.Optional<String>" -->

<h1>Log in</h1>

<p>You can use: demo@localhost / demo</p>

<form role="form" action="/login" method="post">
    <#if _csrf??>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    </#if>

    <div>
        <label for="email">Email address</label>
        <input type="email" name="email" id="email" required autofocus/>
    </div>
    <div>
        <label for="password">Password</label>
        <input type="password" name="password" id="password" required/>
    </div>
    <div>
        <label for="remember-me">Remember me</label>
        <input type="checkbox" name="remember-me" id="remember-me"/>
    </div>
    <button type="submit">Sign in</button>
</form>

    <#if error.isPresent()>
    <p>The email or password you have entered is invalid, try again.</p>
    </#if>
</@skeleton.page >
