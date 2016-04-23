package example;

import javax.validation.constraints.NotNull;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel("News Entry")
public class NewsEntry {
	@ApiModelProperty(value = "the id of the item", required = true)
	private long id;
	@NotNull
	private String content;

	public NewsEntry() {
	}

	public NewsEntry(long id, String b) {
		this.id = id;
		this.content = b;
	}

	public long getId() {
		return this.id;
	}

	public String getContent() {
		return this.content;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
