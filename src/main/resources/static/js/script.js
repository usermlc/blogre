document.addEventListener('DOMContentLoaded', function () {
  fetch('/articles')
  .then(response => response.json())
  .then(articles => {
    const articlesDiv = document.getElementById('articles');
    if (articlesDiv) {
      articlesDiv.innerHTML = '';
      articles.forEach(article => {
        const articleDiv = document.createElement('div');
        articleDiv.classList.add('article');
        articleDiv.innerHTML = `
            <h3><a href="/article.html?id=${article.id}">${article.title}</a></h3>
            <p>${article.content}</p>
          `;
        articlesDiv.appendChild(articleDiv);
      });
    }
  })
  .catch(error => console.error('Error loading articles:', error));

  const articleForm = document.getElementById('articleForm');
  if (articleForm) {
    articleForm.addEventListener('submit', function (e) {
      e.preventDefault();

      const title = document.getElementById('title').value;
      const content = document.getElementById('content').value;

      fetch('/articles', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({
          title: title,
          content: content
        })
      })
      .then(response => response.json())
      .then(article => {
        console.log('Article added:', article);
        const articlesDiv = document.getElementById('articles');
        const newArticleDiv = document.createElement('div');
        newArticleDiv.classList.add('article');
        newArticleDiv.innerHTML = `
          <h3><a href="/article.html?id=${article.id}">${article.title}</a></h3>
          <p>${article.content}</p>
        `;
        articlesDiv.prepend(newArticleDiv);

        document.getElementById('title').value = '';
        document.getElementById('content').value = '';
      })
      .catch(error => console.error('Error adding article:', error));
    });
  }

  const commentForm = document.getElementById('commentForm');
  if (commentForm) {
    commentForm.addEventListener('submit', function (e) {
      e.preventDefault();

      const commentContent = document.getElementById('commentContent').value;
      const author = document.getElementById('author').value;
      const articleId = new URLSearchParams(window.location.search).get('id');

      if (!articleId) {
        console.error('No article id found!');
        return;
      }

      fetch('/comments', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({
          content: commentContent,
          author: author,
          article_id: articleId
        })
      })
      .then(response => response.json())
      .then(comment => {
        console.log('Comment added:', comment);

        const commentsList = document.getElementById('comments-list');
        if (commentsList) {
          const newCommentLi = document.createElement('li');
          newCommentLi.innerHTML = `${comment.author}: ${comment.content}`;
          commentsList.appendChild(newCommentLi);
        }

        document.getElementById('commentContent').value = '';
        document.getElementById('author').value = '';
      })
      .catch(error => console.error('Error adding comment:', error));
    });
  }
});
