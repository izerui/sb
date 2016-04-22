package example;

import java.util.Collection;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@RestController
@Api(value = "news", description = "News API")
public class NewsController {
	private Map<Long, NewsEntry> entries = new ConcurrentHashMap<Long, NewsEntry>();

	public NewsController() {
		for (long i = 0; i < 5; i++)
			this.entries.put(i, new NewsEntry(i, "Title #" + i));
	}

	@RequestMapping(value = "/news", method = RequestMethod.GET)
	@ApiOperation(value = "Get News", notes = "Returns news items")
	Collection<NewsEntry> entries() {
		return this.entries.values();
	}

	@RequestMapping(value = "/news/{id}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Delete News item", notes = "Deletes news item by id")
	NewsEntry remove(@PathVariable Long id) {
		return this.entries.remove(id);
	}

	@RequestMapping(value = "/news/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Get a news item", notes = "Returns a news item")
	NewsEntry entry(@PathVariable Long id) {
		return this.entries.get(id);
	}

	@RequestMapping(value = "/news/{id}", method = RequestMethod.POST)
	@ApiOperation(value = "Update News", notes = "Updates a news item")
	NewsEntry update(@Valid @RequestBody NewsEntry news) {
		this.entries.put(news.getId(), news);
		return news;
	}

	@RequestMapping(value = "/news", method = RequestMethod.POST)
	@ApiOperation(value = "Create News", notes = "Creates a news item")
	NewsEntry add(@Valid @RequestBody NewsEntry news) {
		long id = 10 + new Random().nextInt(99);
		news.setId(id);
		this.entries.put(id, news);
		return news;
	}
}
