<template>
  <div class="container">
    <header class="header">
      <div
        class="header__lang-switcher"
      >
        <span
          @click="switchLang"
        >
          {{ $i18n.locale === 'en' ? 'ru' : 'en' }}
        </span>
      </div>
      <div class="header__links_container">
        <router-link
          to="/video"
          active-class="active"
          class="header__link"
        >
          {{ $t('videos') }}
        </router-link>

        <router-link
          to="/playlist"
          active-class="active"
          class="header__link"
        >
          {{ $t('playlists') }}
        </router-link>
      </div>
    </header>

    <main>
      <router-view />
    </main>

    <footer class="footer">
      <p>
        by <a
          href="https://true-programmers.com"
          target="_blank"
        >true-programmers.com</a>
      </p>
      <a
        href="https://github.com/kto-viktor/youtube-archive"
        target="_blank"
      >Github</a>
    </footer>
  </div>
</template>

<script>
export default {
	methods: {
		switchLang() {
			this.$i18n.locale === 'en' ? this.$i18n.locale = 'ru' : this.$i18n.locale = 'en'
			localStorage.setItem('lang', this.$i18n.locale)
			document.documentElement.setAttribute("lang", this.$i18n.locale);
		}
	}
}
</script>