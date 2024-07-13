using Microsoft.AspNetCore.Mvc;
using projectmau.Data;

namespace projectmau.Models
{
	public class Sidebar:ViewComponent
	{
		private readonly projectmauContext _context;

		public Sidebar(projectmauContext context)
		{
			_context = context;
		}
		public IViewComponentResult Invoke()
		{
			return View(_context.Category.ToList());
		}
	}
}
