/**
 * 
 */
package com.guvvala.music.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.guvvala.music.model.PagedResult;
import com.guvvala.music.model.PlayList;
import com.guvvala.music.model.PlayListInfo;
import com.guvvala.music.repository.PlayListRepository;

/**
 * @author rajaguvvala
 *
 */
@Service
public class PlayListServiceImpl implements PlayListService{

	@Autowired
	private PlayListRepository playListReository;
	
	/**
	 * 
	 * This method returns all the play lists available 
	 * 
	 * @param pageable
	 * @return paginated results of play lists
	 */
	@Override
	public PagedResult<List<PlayList>> getAllMusicTracks(Pageable pageable) {
		//TODO replace PageRequest with some repository method like findAllByOrderedByViewsDesc
		return PagedResult.from(playListReository.findAll(new PageRequest(pageable.getPageNumber(),
				pageable.getPageSize(), new Sort(Direction.DESC, "views"))));
	}
	
	/**
	 * 
	 * This method returns all the play lists matching tag
	 * 
	 * @param tag
	 * @param pageable
	 * @return all play lists matching tag ordered by no of views
	 */
	@Override
	public PagedResult<List<PlayList>> getMusicTracksByTags(String tag, Pageable pageable) {
		// TODO replace PageRequest with some repository method like findByTagsByOrderedByViewsDesc
		return PagedResult.from(playListReository.findByTags(tag, new PageRequest(pageable.getPageNumber(),
				pageable.getPageSize(), new Sort(Direction.DESC, "views"))));
	}

	/**
	 * 
	 * This method provides  search as you type functionality for tags
	 * 
	 * @param tag
	 * @return
	 */
	@Override
	public List<PlayListInfo> suggestMusickTracksByTag(String tag) {
		// find the suggested tags
		List<String> tags = playListReository.findSuggestedTagsByGivenTag(tag);
		
		List<PlayListInfo> playLists = new ArrayList<>();
		tags.forEach(x->{
			playLists.add(new PlayListInfo(x,playListReository.findTotalNumberOfPlaylistsByTag(x)));
		});
		return playLists;
	}

	/**
	 * 
	 * This method provides recommended tags
	 * recommendation is based on the appearance of the other tags along with the searched tag
	 * @param tag
	 * @return recommended tags
	 */
	@Override
	public List<String> recommendMusicTracksByTag(String tag) {
		// find recommended tags
		return playListReository.findRecommendedTagsByGivenTag(tag);
	}

	
	/**
	 * 
	 * This method saves the newly created play list
	 *
	 * @param playList
	 * @return 
	 */
	@Override
	public void save(PlayList playList) {
		playListReository.save(playList);
	}

}
