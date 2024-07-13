using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using projectmau.Data;

namespace projectmau.Models

{
	public class Search : ViewComponent
	{
		private readonly projectmauContext _context;

		public Search(projectmauContext context)
		{
			_context = context;
		}
		public IViewComponentResult Invoke()
		{
			return View(_context.Category.ToList());
		}
	}
}
