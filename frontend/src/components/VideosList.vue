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
          <!--{{ $options.statuses[video.status] }}-->
          {{ $t('statuses.downloaded') }}
          {{ sizeInfo(video.sizeMb) }}
        </a>
        <p
          v-else-if="video.status === 'ERROR'"
          class="text-danger"
        >
          <!--{{ $options.statuses[video.status] }}-->
          {{ $t('statuses.error') }}
        </p>
        <p
          v-else
          class="text-secondary"
        >
          <!--{{ `${$options.statuses[video.status]} (${video.progress}%)` }}-->
          {{ `${$t('statuses.in_progress')} (${video.progress}%)` }}
        </p>
      </td>
    </tr>
  </table>
</template>

<script>
import videosMixin from '@/mixins/videosMixin';
import videoHrefMixin from '@/mixins/videoHrefMixin';
import { useI18n } from "vue-i18n";


	export default {    
		mixins: [videosMixin, videoHrefMixin ],

		props: {
			videos: {
				type: Array,
				default: () => []
			}
		},

		setup() {
      const { t } = useI18n({useScope: 'global'})
      const statuses = {
        'IN_PROGRESS': t('statuses.in_progress'),
        'DOWNLOADED': t('statuses.downloaded'),
        'ERROR': t('statuses.error'),
      }
      return { t, statuses }
    }
	}
</script>

<style lang="scss" scoped></style>