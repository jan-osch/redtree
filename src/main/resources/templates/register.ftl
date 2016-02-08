<#import "/spring.ftl" as spring>
<#import "skeleton.ftl" as skeleton>
<@skeleton.page title="Register">
<h1>Register</h1>

<form role="form" name="form" action="" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    <div>
        <label for="email">Email address</label>
        <input type="email" name="email" id="email" value="${form.email}" required autofocus/>
    </div>
    <div>
        <label for="password">Password</label>
        <input type="password" name="password" id="password" required/>
    </div>
    <div>
        <label for="passwordRepeated">Repeat</label>
        <input type="password" name="passwordRepeated" id="passwordRepeated" required/>
    </div>
    <div>
        <label for="role">Role</label>
        <select name="role" id="role" required>
            <option <#if form.role == 'USER'>selected</#if>>USER</option>
            <option <#if form.role == 'SHOP'>selected</#if>>SHOP</option>
        </select>
    </div>
    <button type="submit">Save</button>
</form>

    <@spring.bind "form" />
    <#if spring.status.error>
    <ul>
        <#list spring.status.errorMessages as error>
            <li>${error}</li>
        </#list>
    </ul>
    </#if>
</@skeleton.page>


