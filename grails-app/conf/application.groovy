
//
grails.plugin.springsecurity.password.algorithm = 'bcrypt'

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'grails.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'grails.UserRole'
grails.plugin.springsecurity.authority.className = 'grails.Role'

grails.plugin.springsecurity.controllerAnnotations.staticRules = [
        [pattern: '/',               access: ['permitAll']],
        [pattern: '/error',          access: ['permitAll']],
        [pattern: '/index',          access: ['permitAll']],
        [pattern: '/index.gsp',      access: ['permitAll']],
        [pattern: '/shutdown',       access: ['permitAll']],
        [pattern: '/assets/**',      access: ['permitAll']],
        [pattern: '/**/js/**',       access: ['permitAll']],
        [pattern: '/**/css/**',      access: ['permitAll']],
        [pattern: '/**/images/**',   access: ['permitAll']],
        [pattern: '/**/favicon.ico', access: ['permitAll']],
        [pattern: '/eventos/**',  access: ['permitAll']],
        [pattern: '/login/**',       access: ['permitAll']],
        [pattern: '/logout/**',      access: ['permitAll']],
        [pattern: '/eventos/create',  access: ['ROLE_ADMIN']],
        [pattern: '/user/**',       access: ['permitAll']],
        [pattern: '/thing/register', access: 'isAuthenticated()', httpMethod: 'PUT']

]

grails.plugin.springsecurity.filterChain.chainMap = [
        [pattern: '/assets/**',      filters: 'none'],
        [pattern: '/**/js/**',       filters: 'none'],
        [pattern: '/**/css/**',      filters: 'none'],
        [pattern: '/**/images/**',   filters: 'none'],
        [pattern: '/**/favicon.ico', filters: 'none'],
        [pattern: '/**',             filters: 'JOINED_FILTERS']
]

grails.plugin.springsecurity.securityConfigType = "Annotation"

//Para permitir el acceso sin la necesidad de reglas.
grails.plugin.springsecurity.rejectIfNoRule = false
grails.plugin.springsecurity.fii.rejectPublicInvocations = false


