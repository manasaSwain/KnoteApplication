package com.cts.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cts.model.Article;
import com.cts.model.ArticleDocument;
import com.cts.model.ContPhoto;
import com.cts.service.IarticleService;
//@RequestMapping("/ctskn")
@Controller
@RequestMapping("/ctskn")
public class ArticleController {

	@Autowired
	IarticleService articleService;
	
	@GetMapping("/")
	public String showHome() {
		
		return "home";
	}

	@GetMapping("/showArticle")
	public String getArticlePage() {

		return "ArticleInput";
	}

	@GetMapping("/showDoc")
	public String showDocs(Model model) {

		List<Object[]> doclist = articleService.getDocumentInfo();
		model.addAttribute("doclist", doclist);
		return "DownloadDoc";
	}

	@PostMapping("/save")
	public String saveShipmentType(
			// Model model
			@RequestParam("articleName") String articleName,
			@RequestParam("articleContributor") String articleContributor,
			@RequestParam("description") String description,
			@RequestParam("contributorPhoto") MultipartFile contributorPhoto,
			@RequestParam("uploadArticle") MultipartFile uploadArticle

	) {
		Article at = new Article();
		ContPhoto cp = new ContPhoto();
		ArticleDocument atdoc = new ArticleDocument();
		try {
			cp.setPhotoData(contributorPhoto.getBytes());
			cp.setPhotoDocName(contributorPhoto.getOriginalFilename());
			atdoc.setArticleDocData(uploadArticle.getBytes());
			atdoc.setArticleDocName(uploadArticle.getOriginalFilename());
			at.setArticleContributor(articleContributor);
			at.setArticleName(articleName);
			at.setContPhoto(cp);
			at.setArticleDocument(atdoc);
			at.setDescription(description);

		} catch (IOException e) {

			e.printStackTrace();
		}
		articleService.saveArticle(at);

		return "redirect:showArticle";
	}

	@GetMapping("/downloads")
	public void getDocumentData(@RequestParam("id") Integer docid, HttpServletResponse response) {
		Optional<ArticleDocument> optdata = articleService.getDocumentById(docid);
		if (optdata.isPresent()) {
			ArticleDocument artdoc = optdata.get();
			response.addHeader("Content-Disposition", "attachment;filename=" + artdoc.getArticleDocName());
			try {
				FileCopyUtils.copy(artdoc.getArticleDocData(), response.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
}
