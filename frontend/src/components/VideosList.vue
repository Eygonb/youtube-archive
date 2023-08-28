<template>
  <table 
    class="list-videos"
  >
    <tr
      v-for="video in videos"
      :key="video.id"
      class="list-videos__item"
    >
      <td>{{ video.title }}</td>
      <td>
        <a
          v-if="video.status === 'DOWNLOADED'"
          :href="videoHref(video)"
          download
          target="_blank"
        >
          {{ statuses[video.status] }}
          {{ sizeInfo(video.sizeMb) }}
        </a>
        <p
          v-else-if="video.status === 'ERROR'"
          class="text-danger"
        >
          {{ statuses[video.status] }}
        </p>
        <p
          v-else
          class="text-secondary"
        >
          {{ `${statuses[video.status]} (${video.progress}%)` }}
        </p>
      </td>
    </tr>
  </table>
</template>

<script>
import videosMixin from '@/mixins/videosMixin';
import videoHrefMixin from '@/mixins/videoHrefMixin';

export default {    
	mixins: [videosMixin, videoHrefMixin ],

	props: {
		videos: {
			type: Array,
			default: () => []
		}
	},

	computed: {
		statuses() {
			return {
			'IN_PROGRESS': this.$t('statuses.in_progress'),
			'DOWNLOADED': this.$t('statuses.downloaded'),
			'ERROR': this.$t('statuses.error'),
			}
		}
	}
}
</script>

<style lang="scss" scoped></style>